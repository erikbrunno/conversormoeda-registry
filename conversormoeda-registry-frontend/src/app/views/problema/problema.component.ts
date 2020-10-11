import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HeaderService } from 'src/app/components/template/header/header.service';

@Component({
  selector: 'app-problema',
  templateUrl: './problema.component.html',
  styleUrls: ['./problema.component.css']
})
export class ProblemaComponent implements OnInit {

  constructor(
    private headerService: HeaderService
  ) { 
    headerService.header = {
      title: 'Problemas reportados',
      icon: 'report_problem',
      routerUrl: '/problemas'
    }
  }

  ngOnInit(): void {
  }
}
