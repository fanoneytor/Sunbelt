import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import Swal from 'sweetalert2';
import { CommonModule } from '@angular/common';
import { ApiConsultaService } from '../../services/api-consulta.service';

@Component({
  selector: 'app-main',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './main.component.html',
  styleUrl: './main.component.css'
})
export class MainComponent {
  tipo_documento : string = '';
  numero_documento : string = '';
  resultado : boolean = false;
  usuario_encontrado : boolean = false;
  usuario : any = {};

  constructor(private apiService: ApiConsultaService){

  }

  consultarUsuario() {
    this.apiService.consultarUsuario(this.tipo_documento, this.numero_documento)
      .subscribe(
        (data: any) => {
          this.usuario = data;
          this.usuario_encontrado = true;
          this.resultado = true;
        },
        (error) => {
          this.resultado = true;
          this.usuario_encontrado = false;
          
          Swal.fire('Se ha Generado un Error', error.error, 'error');
        }
      );
  }

}
