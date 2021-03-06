import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { BookComponent } from './Admin/book/book.component';
import { FormBookComponent } from './Admin/book/form-book/form-book.component';
import { ItemBookComponent } from './Admin/book/list-book/item-book/item-book.component';
import { ListBookComponent } from './Admin/book/list-book/list-book.component';
import { DashboardComponent } from './Admin/dashboard/dashboard.component';
import { HomeComponent } from './Admin/home/home.component';

const routes: Routes = [
  { path: 'admin', redirectTo: '/admin/dashboard', pathMatch: 'full' },
  {
    path: 'admin',
    component: DashboardComponent,
    children: [
      {
        path: 'dashboard',
        component: HomeComponent,
        pathMatch: 'full',
      },
      {
        path: 'book',
        component: BookComponent,
        children: [
          {
            path: '',
            component: ListBookComponent,
            children:[
              {
                path: 'new',
                component: FormBookComponent,
                pathMatch: 'full',
              },
              {
                path: 'edit/:id',
                component: FormBookComponent,
                pathMatch: 'full',
              },
            ]
          },
          
          {
            path: ':id',
            component: ItemBookComponent,
            pathMatch: 'full',
          },
        ],
      },
    ],
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
