import { Injectable } from '@angular/core';
import { Cliente } from './clientes/cliente';
import { HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class ClientesService {

  constructor(private http: HttpClient) { 
   
  }

  salvar(cliente : Cliente) : Observable<Cliente>{
    return this.http.post<Cliente>('http://localhost:8090/clientes',cliente);
  }


  
  allClientes(): Observable<Cliente[]>{
   return this.http.get<Cliente[]>('http://localhost:8090/clientes');
  }
  

  getClienteById(id: number): Observable<Cliente>{
    return this.http.get<any>(`http://localhost:8090/clientes/${id}`);
  }

  deleteCliente(id: number) : Observable<any>{
    return this.http.delete<any>(`http://localhost:8090/clientes/${id}`);
  }
}
