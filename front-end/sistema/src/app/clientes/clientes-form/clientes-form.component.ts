import { Cliente } from './../cliente';
import { Component, OnInit } from '@angular/core';
 import { ClientesService} from '../../clientes.service';
import { Router, ActivatedRoute, Params } from '@angular/router';
import { Observable } from 'rxjs';
@Component({
  selector: 'app-clientes-form',
  templateUrl: './clientes-form.component.html',
  styleUrls: ['./clientes-form.component.css']
})
export class ClientesFormComponent implements OnInit {
  title: string ="Cadastro de clientes"
  
  cliente!: Cliente;
  success: boolean = false;
  erros!: string[];
  errors: null;
  id!: any;

  constructor(
    //Declaração de service
    private clienteService: ClientesService,
    private activatedRoute :ActivatedRoute
 
  ) {
    this.cliente = new Cliente();
    
   }

  ngOnInit(): void {
     let param: Observable<Params> = this.activatedRoute.params;
     param.subscribe(
       urlParams =>{
        this.id = urlParams['id'];
        if(this.id){
         this.clienteService
          .getClienteById(this.id)
          .subscribe(response => this.cliente = response,
            errorResponse => this.cliente = new Cliente()
          )}
       });
  }
  
  onSubmit(){
    this.clienteService.salvar(this.cliente)
    .subscribe(response =>{
      this.success = true;
      this.errors = null;
      this.cliente = response;
    },errorResponse =>{
      this.success = false;
      this.erros = errorResponse.error.errors;
      
    })
  }
  
}
