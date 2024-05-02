import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ApiConsultaService {
  private apiUrl = 'http://3.95.235.230:8090/'

  constructor(private http: HttpClient) {
  }

  consultarUsuario(tipoDocumento: string, numeroDocumento: string): Observable<any> {
    return this.http.post<any>(this.apiUrl + 'api/cliente/consultarCliente', {
      "tipoDocumento": tipoDocumento,
      "numeroDocumento": numeroDocumento
    })
  }

}
