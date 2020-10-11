import { ProblemaService } from '../../servicos/problema.service';
import { Component, OnInit } from '@angular/core';
import { ProblemaModel } from 'src/app/modelo/problema.model';

@Component({
  selector: 'app-problema-list',
  templateUrl: './problema-list.component.html',
  styleUrls: ['./problema-list.component.css']
})
export class ProblemaListComponent implements OnInit {

  public panelOpenState = false;
  public displayedColumns = ['titulo', 'codigoHttp', 'detalhe', 'dataHora', 'acao']
  public problemas: ProblemaModel[]

  constructor(
    private problemaService: ProblemaService
  ) { }

  ngOnInit(): void {
    this.problemaService.consultar().subscribe((problemas: ProblemaModel[]) => {
      this.problemas = problemas
    })
  }

}
