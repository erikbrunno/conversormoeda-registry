import { ProblemaDetalheComponent } from './components/problema-detalhe/problema-detalhe.component';

import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ProblemaComponent } from './views/problema/problema.component';
import { HomeComponent } from './views/home/home.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'problemas', component: ProblemaComponent },
  { path: 'problemas/:id/detalhar', component: ProblemaDetalheComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
