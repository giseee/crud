import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Persona } from 'src/app/Modelos/Persona';
import {ServiceService} from '../../Service/service.service'
import { Observable, EMPTY } from "rxjs";
import { map, catchError } from "rxjs/operators";
import { HttpClient } from "@angular/common/http";
@Component({
  selector: 'app-listar',
  templateUrl: './listar.component.html',
  styleUrls: ['./listar.component.css']
})
export class ListarComponent implements OnInit {

  personas: Persona[] | undefined;
  constructor(private service: ServiceService, private router: Router) { }

  ngOnInit() {
    this.service.getPersonas()
      .subscribe(data => {
        this.personas = data;
      });
  }
  Editar(persona:Persona):void{
    localStorage.setItem("id",persona.id.toString());
    this.router.navigate(["edit"]);
  }

  Delete(persona:Persona){
    this.service.deletePersona(persona)
    .subscribe(data=>{
     // this.personas=this.personas.filter(p=>p!==persona);
      alert("Usuario eliminado...");
      this.router.navigate(["listar"]);
    })
  }

}

