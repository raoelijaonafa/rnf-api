package com.rnf.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rnf.controller.common.BaseRestController;
import com.rnf.model.request.SaveUserRequest;
import com.rnf.model.response.PaginatedResponseModel;
import com.rnf.model.response.ResponseModel;
import com.rnf.model.user.UserViewModel;
import com.rnf.service.user.UserService;

@RestController
public class UserRestController extends BaseRestController {
	@Autowired
	private UserService userService;
	
	@GetMapping("${v1API}/users/find-view-by-id/{id}")
	@PreAuthorize("hasRole('ROLE_SUPERADMIN')")
	public Object findUserViewAction(@PathVariable int id) {
		return this.userService.findUserViewById(id);
	}
	
	@PostMapping("${v1API}/users/list-view-dt")
	@PreAuthorize("hasRole('ROLE_SUPERADMIN')")
	public Object listAllDtUsersAction(@RequestBody Map<String,Object> body) {
		PaginatedResponseModel<UserViewModel> res = new PaginatedResponseModel<>();
		
		int index = this.getIntegerFromBodyRequest(body, "index");
		int count = this.getIntegerFromBodyRequest(body, "count");
		String search = this.getStringFromBodyRequest(body, "search");
		Integer etat = this.getIntegerFromBodyRequest(body, "etat");
		String departement = this.getStringFromBodyRequest(body, "departement");
		
		int totalCount = 0;
		
		List<UserViewModel> models = this.userService.listViewDtUser(index, count, search, etat, departement);
		totalCount = this.userService.countViewDtUser(search, etat, departement);
		
		res.setData(models);
		res.setLength(totalCount);
		
		return res;
	}
	
	@PostMapping("${v1API}/users/save")
	@PreAuthorize("hasRole('ROLE_SUPERADMIN')")
	public Object saveUserAction(@RequestBody SaveUserRequest saveUserRequest) {
		return this.userService.saveUser(saveUserRequest);
	}
	
	@PostMapping("${v1API}/users/update/{idNewOrganigramme}/{idNewRole}")
	@PreAuthorize("hasRole('ROLE_SUPERADMIN')")
	public Object updateUserAction(@RequestBody UserViewModel userViewModel,
			@PathVariable int idNewOrganigramme, @PathVariable int idNewRole) {
		
		return this.userService.updateUser(userViewModel, idNewOrganigramme, idNewRole);
	}
	
	@GetMapping("${v1API}/users/disable/{idUser}")
	@PreAuthorize("hasRole('ROLE_SUPERADMIN')")
	public Object disableUserAction(@PathVariable int idUser) {
		return this.userService.disableUser(idUser);
	}
	
	@GetMapping("${v1API}/users/get-roles-by-id-user/{idUser}")
	@PreAuthorize("hasRole('ROLE_SUPERADMIN')")
	public Object getRolesByUserIdAction(@PathVariable int idUser) {
		return this.userService.getRolesByUserId(idUser);
	}
	
	@GetMapping("${v1API}/users/reset-password-by-id-user/{idUser}")
	@PreAuthorize("hasRole('ROLE_SUPERADMIN')")
	public Object resetPasswordAction(@PathVariable int idUser) {
		return this.userService.resetPasswod(idUser);
	}
	
	@GetMapping("${v1API}/users/check-user-if-new-password/{idUser}")
	@PreAuthorize("hasRole('ROLE_SUPERADMIN') or hasRole('ROLE_GESTIONNAIRE') or hasRole('ROLE_ADMIN')")
	public ResponseModel checkUserIsNewPasswordAction(@PathVariable int idUser) {
		return this.userService.checkUserIfNewPassword(idUser);
	}
	
	@PostMapping("${v1API}/users/update-password")
	@PreAuthorize("hasRole('ROLE_SUPERADMIN') or hasRole('ROLE_GESTIONNAIRE') or hasRole('ROLE_ADMIN')")
	public ResponseModel updatePasswordAction(@RequestBody Map<String,Object> body) {
		Integer idUser = this.getIntegerFromBodyRequest(body, "idUser");
		String newPassword = this.getStringFromBodyRequest(body, "newPassword");
		
		return this.userService.updatePassword(idUser, newPassword);
	}
}
