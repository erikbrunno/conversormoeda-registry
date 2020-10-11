import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { RastreamentoProblemaModel } from 'src/app/modelo/rastreamento-problema.model';
import { RastreamentoProblemaService } from 'src/app/servicos/rastreamento-problema.service';

@Component({
  selector: 'app-problema-detalhe',
  templateUrl: './problema-detalhe.component.html',
  styleUrls: ['./problema-detalhe.component.css']
})
export class ProblemaDetalheComponent implements OnInit {

  public rastreamentoProblema: RastreamentoProblemaModel

  constructor(
    private rastreamentoProblemaService: RastreamentoProblemaService,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id')
			this.rastreamentoProblemaService.buscar(id).subscribe((rastreamentoProblema: RastreamentoProblemaModel) => {
			  this.rastreamentoProblema = rastreamentoProblema
		})
  }

}
