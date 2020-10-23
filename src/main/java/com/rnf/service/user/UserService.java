package com.rnf.service.user;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rnf.core.modelentitymapper.reflection.ModelEntityMapper;
import com.rnf.entity.referentiel.MinistereEntity;
import com.rnf.entity.user.RoleEntity;
import com.rnf.entity.user.UserEntity;
import com.rnf.entity.user.UserViewEntity;
import com.rnf.misc.EnumEtatUser;
import com.rnf.misc.EnumRole;
import com.rnf.model.request.SaveUserRequest;
import com.rnf.model.response.ResponseModel;
import com.rnf.model.user.RoleModel;
import com.rnf.model.user.UserModel;
import com.rnf.model.user.UserViewModel;
import com.rnf.repository.referentiel.MinistereEntityRepository;
import com.rnf.repository.user.RoleEntityRepository;
import com.rnf.repository.user.UserEntityRepository;
import com.rnf.repository.user.UserViewCustomRepository;

@Service
public class UserService implements UserDetailsService {
	public static final int DEFAULT_PASSWORD = 1;
	
	@Autowired
	private UserEntityRepository userEntityRepository;
	
	@Autowired
	private UserViewCustomRepository userViewCustomRepository;
	
	@Autowired
	private MinistereEntityRepository ministereEntityRepository;
	
	@Autowired
	private RoleEntityRepository roleEntityRepository;
	
	@Autowired
	private PasswordEncoder encoder;
	
	private ModelEntityMapper<UserEntity, UserModel> userModelFactory;
	private ModelEntityMapper<UserViewEntity, UserViewModel> userViewModelFactory;
	private ModelEntityMapper<RoleEntity, RoleModel> roleModelFactory;
	
	public UserService() {
		this.userModelFactory = new ModelEntityMapper<>(UserEntity.class, UserModel.class);
		this.userViewModelFactory = new ModelEntityMapper<>(UserViewEntity.class, UserViewModel.class);
		this.roleModelFactory = new ModelEntityMapper<>(RoleEntity.class, RoleModel.class);
	}
	

 
 
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity entity = userEntityRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

		UserModel model = this.userModelFactory.createModelFromEntity(entity);
		List<GrantedAuthority> authorities = entity.getRoles().stream()
				.map(role -> new SimpleGrantedAuthority(role.getName().name()))
				.collect(Collectors.toList());
		model.setAuthorities(authorities);
		
		return model;
	}
	
	public UserModel findUserById(int idUser) {
		UserEntity entity = this.userEntityRepository.findById(idUser).get();
		UserModel model = this.userModelFactory.createModelFromEntity(entity);
		
		return model;
	}
	
	public UserViewModel findUserViewById(int idUser) {
		UserViewEntity entity = this.userViewCustomRepository.findViewById(idUser);
		UserViewModel model = this.userViewModelFactory.createModelFromEntity(entity);
		
		return model;
	}
	
	public List<UserViewModel> listViewDtUser(int index, int count, String search, Integer etat, String departement) {
		List<UserViewEntity> entities = this.userViewCustomRepository.listViewDtUser(index, count, search, etat, departement);
		List<UserViewModel> models = this.userViewModelFactory.createModelsFromEntities(entities);
		
		return models;
	}
	
	public int countViewDtUser(String search, Integer etat, String departement) {
		return this.userViewCustomRepository.countViewDtUser(search, etat, departement);
	}
	
	public ResponseModel saveUser(SaveUserRequest req) {
		ResponseModel res = new ResponseModel();
		
		UserEntity userEntity = new UserEntity();
		
		userEntity.setUsername(req.getUsername());
		userEntity.setPassword(this.encoder.encode(req.getPassword()));
		userEntity.setNom(req.getNom());
		userEntity.setPrenom(req.getPrenom());
		
		//Set ministere
		MinistereEntity ministereEntity = this.ministereEntityRepository.findById(req.getIdMinistere()).get();
		userEntity.getConsuMinisteres().add(ministereEntity);
		this.ministereEntityRepository.save(ministereEntity);
		
		//Update role
		RoleEntity roleEntity = this.roleEntityRepository.findById(req.getIdRole()).get();
		userEntity.getRoles().add(roleEntity);
		this.roleEntityRepository.save(roleEntity);
		
		this.userEntityRepository.save(userEntity);
		
		res.setMessage("Profil utilisateur enregistré");
		
		res.setSuccess(true);
		
		return res;
	}
	
	public ResponseModel updateUser(UserViewModel userViewModel, int idMinistere, int idNewRole) {
		ResponseModel res = new ResponseModel();
		
		UserEntity userEntity = this.userEntityRepository.findById(userViewModel.getIdUser()).get();
		userEntity.setUsername(userViewModel.getUsername());
		userEntity.setNom(userViewModel.getNom());
		userEntity.setPrenom(userViewModel.getPrenom());
		 
		userEntity.setEtat(userViewModel.getEtat());
		
		//Update ministere
		MinistereEntity ministereENtity = this.ministereEntityRepository.findById(idMinistere).get();
		userEntity.getConsuMinisteres().clear();
		this.ministereEntityRepository.save(ministereENtity);
		
		//Update role
		RoleEntity roleEntity = this.roleEntityRepository.findById(idNewRole).get();
		userEntity.getRoles().clear();
		userEntity.getRoles().add(roleEntity);
		this.roleEntityRepository.save(roleEntity);
		
		this.userEntityRepository.save(userEntity);
		
		res.setMessage("Profil utilisateur mise à jour");
		res.setSuccess(true);
		
		return res;
	}
	
	public ResponseModel disableUser(int idUser) {
		ResponseModel res = new ResponseModel();
		
		UserEntity userEntity = this.userEntityRepository.findById(idUser).get();
		userEntity.setEtat(EnumEtatUser.DESACTIVEE.getValue());
		this.userEntityRepository.save(userEntity);
		
		res.setMessage("Utilisateur desactivé");
		res.setSuccess(true);
		
		return res;
	}
	
	public List<RoleModel> getRolesByUserId(int idUser) {		
		UserEntity userEntity = this.userEntityRepository.findById(idUser).get();
		
		List<RoleEntity> roles = new ArrayList<>();
		for(RoleEntity role : userEntity.getRoles()) {
			roles.add(role);
		}

		List<RoleModel> models = this.roleModelFactory.createModelsFromEntities(roles);
		
		return models;
	}
	
	public ResponseModel resetPasswod(int idUser) {
		ResponseModel res = new ResponseModel();
		
		UserEntity userEntity = this.userEntityRepository.findById(idUser).get();
		userEntity.setPassword(this.encoder.encode("" + DEFAULT_PASSWORD));
		userEntity.setResetPassword(1);
		
		this.userEntityRepository.save(userEntity);
		
		res.setSuccess(true);
		res.setMessage("Reset user password");
		
		return res;
	}
	
	public ResponseModel checkUserIfNewPassword(int idUser) {
		UserEntity userEntity = this.userEntityRepository.findById(idUser).get();
		
		ResponseModel res = new ResponseModel();
		
		res.setSuccess(userEntity.getResetPassword() == 1);
		res.setMessage("Check if user password is new");
		
		return res;
	}
	
	public ResponseModel updatePassword(Integer idUser, String newPassword) {
		UserEntity userEntity = this.userEntityRepository.findById(idUser).get();
		userEntity.setPassword(this.encoder.encode(newPassword));
		userEntity.setResetPassword(0);
		this.userEntityRepository.save(userEntity);
		
		ResponseModel res = new ResponseModel();
		
		res.setSuccess(true);
		res.setMessage("Password updated");
		
		return res;
	}
}
