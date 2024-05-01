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
  tipoDocumento : string = '';
  numeroDocumento : string = '';
  resultado : boolean = false;
  usuarioEncontrado : boolean = false;
  usuario : any = {};

  constructor(private apiService: ApiConsultaService){

  }

  consultarUsuario() {
    this.apiService.consultarUsuario(this.tipoDocumento, this.numeroDocumento)
      .subscribe(
        (data: any) => {
          this.usuario = data;
          this.usuarioEncontrado = true;
          this.resultado = true;
        },
        (error) => {
          this.resultado = true;
          this.usuarioEncontrado = false;
          
          Swal.fire('El dato no existe', error.error, 'error');
        }
      );
  }

}
