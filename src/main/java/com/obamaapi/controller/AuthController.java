package com.obamaapi.controller;

import com.obamaapi.dto.requests.StaffLogInRequest;
import com.obamaapi.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    AuthService authService;

//    @PostMapping("/register")
//    public ResponseEntity signup(@RequestBody PatientSignUpRequest patientSignUpRequest) {
//
//        if(authService.checkIfEmailExists(patientSignUpRequest.getEmail())){
//            return ResponseEntity.badRequest().body("Email Exists");
//        }
//        try {
//            PatientRegisterResponse response = authService.createAccount(patientSignUpRequest);
//            return ResponseEntity.ok().body(response);
//        }catch (Exception e){
//            return ResponseEntity.badRequest().body("Patient Registration Failed");
//        }
//
//    }

//    @PostMapping("/login")
//    public ResponseEntity<?> login(@RequestBody SignInRequest signInRequest) {
//        //get object of relavant user
//
//        String email = signInRequest.getEmail();
//        //continue if staff exists on provided details
//        if (authService.checkIfStaffExists(email)) {
//            try {
//                SignInResponse response = authService.login(signInRequest);
//                return ResponseEntity.ok(response);
//            }catch (Exception e){
//                return ResponseEntity.badRequest().body("Invalid Password");
//            }
//        } else {
//            return ResponseEntity.badRequest().body("UserName or email Invalid");
//
//        }
//    }

    @PostMapping("/staff/login")
    public ResponseEntity<?> patientlogin(@RequestBody StaffLogInRequest staffLogInRequest) {
        //get object of relavant user

        Integer patientNumber = signInRequest.getPatientNumber();
        //continue if user exists on provided details
        if (authService.checkIfIdExists(patientNumber) != null) {
            try {
                PatientSignInResponse response = authService.patientlogin(signInRequest);
                return ResponseEntity.ok(response);
            }catch (Exception e){
                return ResponseEntity.badRequest().body("Invalid Password");
            }
        } else {
            return ResponseEntity.badRequest().body("UserName or email Invalid");

        }
    }

//    @GetMapping("/getPatient/{patientNumber}")
//    public ResponseEntity getPatientDetailsById(@PathVariable String patientNumber){
//        Integer patientNo = Integer.parseInt(patientNumber);
//        if(authService.checkIfIdExists(patientNo)==null){
//            return ResponseEntity.badRequest().body("Patient Does Not Exists");
//        }else return ResponseEntity.ok().body(authService.checkIfIdExists(patientNo));
//    }
}
