import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map, catchError } from 'rxjs/operators';
import { MatSnackBar } from '@angular/material/snack-bar'
import { Observable, EMPTY } from 'rxjs';
import { ProblemaModel } from '../modelo/problema.model';
@Injectable({
  providedIn: 'root'
})
export class ProblemaService {

    private baseUrl = "http://localhost:8081/problemas"
    
    constructor(
        private snackBar: MatSnackBar,
        private http: HttpClient
    ) { }

    public consultar(): Observable<ProblemaModel[]> {
        return this.http.get<ProblemaModel[]>(this.baseUrl)
          .pipe(
            map(obj => obj),
            catchError(e => this.errorHandler(e))
        )
    }

    private errorHandler(e: any): Observable<any> {
        this.exibirMensagem(e.error.userMessage, true)
        return EMPTY
    }

    public exibirMensagem(mensagem: string, temErro: boolean = false): void {
       this.snackBar.open(mensagem, 'X', {
            duration: 3000,
            horizontalPosition: 'right',
            verticalPosition: 'top',
            panelClass: temErro ? ['msg-erro'] : ['msg-sucesso']
        })
    }
}
