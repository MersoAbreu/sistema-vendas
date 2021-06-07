import { RouterModule } from '@angular/router';
import { CommonModule} from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { SidebarComponent } from './sidebar/sidebar.component';
import { FooterComponent } from './footer/footer.component';
import { HomeComponent } from './home/home.component';
import { LayoutSidbarComponent } from './layout-sidbar/layout-sidbar.component';
import { ClientesModule } from './clientes/clientes.module';
import { ClientesService } from './clientes.service';


@NgModule({
  declarations: [
    AppComponent,
    NavBarComponent,
    SidebarComponent,
    FooterComponent,
    HomeComponent,
    LayoutSidbarComponent
  ],
  imports: [
    CommonModule,
    RouterModule,
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    ClientesModule,
    
  ],
  exports:[
    NavBarComponent,
    SidebarComponent
  ],
  providers: [
    ClientesService
  ],
  bootstrap: [AppComponent]
})
export class AppModule {

 }
