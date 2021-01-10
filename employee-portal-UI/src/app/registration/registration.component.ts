import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { AppService } from 'src/app/app.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})

export class RegistrationComponent implements OnInit {
  submitted = false;
  errorMessage : string= "";
  invalidForm: boolean = false;
  genderList : Array<string> = ["Male", "Female"];
  departmentList : Array<string> = ["HR", "Engineering", "Marketing", "Admin"];
  constructor(private service : AppService) { }
  
  ngOnInit() {
  }

  registration = new FormGroup({
    'firstName': new FormControl('',[
      Validators.required,
      Validators.minLength(3)
      ]),
    'lastName': new FormControl('', [
      Validators.required,
      Validators.minLength(3)
      ]),
    'gender': new FormControl('', Validators.required),
    'dateOfBirth': new FormControl('', Validators.required),
    'department': new FormControl('', Validators.required)
  });

  onSubmit() {
    this.submitted = true;
    this.errorMessage = '';
    if (this.registration.invalid) {
        this.invalidForm = true;
        this.errorMessage = "Please fill form without any errors!";
        this.messageHandler();
        return;
    }

    this.service.createEmployee(this.registration.value).subscribe((response) => {
      this.invalidForm = false;
      this.errorMessage = "Employee created successfully!";
      this.messageHandler()
      this.registration.reset();
    },
    (error) => {
      this.invalidForm = false;    
      this.errorMessage = "Error while submitting form!";
      this.messageHandler()        
      return Observable.throw(error);
    })
  }

  messageHandler(){
    setTimeout(() =>{
      this.errorMessage = "";
      this.submitted = false;
    }, 1500)
  }

}
