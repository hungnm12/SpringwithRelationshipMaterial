import { Component } from '@angular/core';
import {HttpClient} from '@angular/common/http';
@Component({
  selector: 'app-course',
  templateUrl: './course.component.html',
  styleUrls: ['./course.component.css']
})
export class CourseComponent {
    CourseArray : any[] = [];
    isResultLoaded = false;
    courseName: string="";
    description: string="";
    currentcourseid = "";
    //link to api
    constructor(private http : HttpClient) 
    {
      this.getAllCourses();
    }
    getAllCourses()
      {
        this.http.get("http://localhost:8081/course/getAllCourse") 
        .subscribe((resultData: any)=>
        {
          this.isResultLoaded = true;
          console.log(resultData);
          this.CourseArray = resultData;
        });
      }
      register() {
       let bodyData = {
        "coursename" : this.courseName,
        "description" : this.description
       };
       this.http.post("http://localhost:8081/customer/save",bodyData,{responseType: 'text'}).subscribe((resultData: any)=>{
        console.log(resultData);
        alert("Course registed successfully");
        this.getAllCourses();

        this.courseName = '';
        this.description = '';
       });
      }
      setUpdate(data: any) {
        this.courseName = data.coursename;
        this.description = data.description;
        this.currentcourseid = data.currentcourseid;
      }
      UpdateRecords() {
          let bodyData = {
            "courseid" : this.currentcourseid,
            "coursename" : this.courseName,
            "description" : this.description
          };
          this.http.put("http://localhost:8081/customer/update",bodyData,{responseType: 'text'}).subscribe((resultData: any)=>
          {
                  console.log(resultData);
                  this.getAllCourses();
                  this.courseName = '';
                  this.description = '';
          });
          
      }
      save() {
        if(this.currentcourseid == '')
        {
          this.register();

        }
        else 
        {
          this.UpdateRecords();
        }
      }
      setDelete(data : any) 
      {
        this.http.delete("http://localhost:8081/customer/delete"+ "/" + data.courseid,{responseType: 'text'}).subscribe((resultData: any)=>
       {
          console.log(resultData);
          this.getAllCourses();
          this.courseName = '';
          this.description = '';
       });
      }
  }
