import { Component, OnInit } from '@angular/core';
import { AppService } from 'src/app/app.service';

@Component({
  selector: 'user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {
  employeeList : Array<object> = []
  constructor(private service : AppService) { }

  ngOnInit() {
    this.service.getAllEmployees().subscribe((employees : Array<object>)=>{
      this.employeeList = employees;
    })
  }

}
