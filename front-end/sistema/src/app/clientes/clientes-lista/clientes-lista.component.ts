import { ClientesService } from './../../clientes.service';
import { Component, OnInit } from '@angular/core';
import { Cliente } from '../cliente';

@Component({
  selector: 'app-clientes-lista',
  templateUrl: './clientes-lista.component.html',
  styleUrls: ['./clientes-lista.component.css']
})
export class ClientesListaComponent implements OnInit {
  title="Consulta clientes"
  clientes: Cliente[] = [];
  clienteSelecionado!: Cliente;
  messagemSucesso!: string;
  menssagemErro!: string;

  constructor(private clienteService: ClientesService) {
 
   }

  ngOnInit(): void {
    this.clienteService
    .allClientes()
    .subscribe(response=> this.clientes = response);
  
  }
  preparaDelete(cliente: Cliente){
    this.clienteSelecionado = cliente;
  }

  deleteCliente(){
    this.clienteService
    .deleteCliente(this.clienteSelecionado.id)
    .subscribe(
      response => {this.messagemSucesso ="Cliente deletado com sucesso!",
      this.ngOnInit();
    },
      erro => this.menssagemErro ="Ocorreu erro ao deletar cliente."
    
   )
  }
}
