import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AppService {
  public headers: HttpHeaders;
  public baseUrl = "http://localhost:8080";

  constructor(private http: HttpClient) { 
    this.headers = new HttpHeaders({
      'Content-Type': 'application/json',
      'Access-Control-Allow-Origin': '*',
      'Access-Control-Allow-Headers': 'Origin, X-Requested-With, Content-Type, Accept',
    });
  }

  getAllEmployees(){
    let URL = this.baseUrl+"/employee";
    return this.http.get(URL, {headers: this.headers});
  }

  createEmployee(body:object){
    let URL = this.baseUrl+"/employee";
    return this.http.post(URL, body, {headers: this.headers});
  }
}
