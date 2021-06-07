import { ClientesListaComponent } from './clientes-lista/clientes-lista.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ClientesFormComponent } from './clientes-form/clientes-form.component';
const routes: Routes = [
  {path: 'clientes-forms', component: ClientesFormComponent},
  {path: 'clientes-forms/:id', component: ClientesFormComponent},
  {path: 'clientes-lista', component: ClientesListaComponent}
 
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ClientesRoutingModule { }
