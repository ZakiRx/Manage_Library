import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { DashboardComponent } from './Admin/dashboard/dashboard.component';
import { SidebarComponent } from './Admin/dashboard/sidebar/sidebar.component';
import { HomeComponent } from './Admin/home/home.component';
import {MatTableModule} from '@angular/material/table';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatSortModule } from '@angular/material/sort';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { BookComponent } from './Admin/book/book.component';
import { FormBookComponent } from './Admin/book/form-book/form-book.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ListBookComponent } from './Admin/book/list-book/list-book.component';
import { ItemBookComponent } from './Admin/book/list-book/item-book/item-book.component';
import { WordCountPipePipe } from './Admin/pipe/word-count.pipe';
import { PowPipe } from './Admin/pipe/pow.pipe';
import { OrderPipe } from './Admin/book/pipe/order.pipe';
import { LoginComponent } from './Auth/login/login.component';
import { SignUpComponent } from './Auth/sign-up/sign-up.component';


@NgModule({
  declarations: [
    AppComponent,
    DashboardComponent,
    SidebarComponent,
    HomeComponent,
    BookComponent,
    FormBookComponent,
    ListBookComponent,
    ItemBookComponent,
    WordCountPipePipe,
    PowPipe,
    OrderPipe,
    LoginComponent,
    SignUpComponent,
  
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MatTableModule,
    BrowserAnimationsModule,
    MatPaginatorModule,
    MatSortModule,
    NgbModule,
    ReactiveFormsModule,
    FormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
