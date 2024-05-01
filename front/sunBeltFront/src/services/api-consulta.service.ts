import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ApiConsultaService {
  private apiUrl = 'http://localhost:8090/'

  constructor(private http: HttpClient) {
  }

  consultarUsuario(tipo_documento: string, numero_documento: string): Observable<any> {
    return this.http.post<any>(this.apiUrl + 'api/cliente/consultarCliente', {
      "tipo_documento": tipo_documento,
      "numero_documento": numero_documento
    })
  }

}
