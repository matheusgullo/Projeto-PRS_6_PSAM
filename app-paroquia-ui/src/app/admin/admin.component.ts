import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { AdminService } from './admin.service';
import { Missa } from 'src/app/core/model';
import { Paroquia } from 'src/app/core/model';
import { ActivatedRoute } from '@angular/router';
import { ErrorHandlerService } from '../core/error-handler.service';
import { ConfirmationService, MessageService } from 'primeng/api';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  listaMissa = []; 

  missas = [];

  infoParoquia;

  missa = new Missa();

  paroquia = new Paroquia();

  constructor(
              private adminService: AdminService, 
              private route: ActivatedRoute,
              private errorHandler: ErrorHandlerService,
              private messageService: MessageService,
              private confirmation: ConfirmationService) { }

  ngOnInit(): void {
    this.listarMissa();
    this.listarParoquia();
  }

  listarMissa(): void{
    this.adminService.listarMissa()
    .then(resultado => { 
      this.listaMissa = resultado;
    });
  }

  listarParoquia(): void{
    this.adminService.listarParoquia()
    .then(resultado => { 
      this.infoParoquia = resultado;
    })
    .catch(erro => this.errorHandler.handle(erro));
  }

  atualizarMissa(missa: Missa): void{
    this.adminService.atualizarMissa(missa)
      .then(missa => {
        missa = missa; 

        this.messageService.add({ severity: 'success', detail: 'Informações alteradas com sucesso!' });
      })
      .catch(erro => this.errorHandler.handle(erro));

  }

  atualizarParoquia(paroquia: Paroquia): void{ 
    this.adminService.atualizarParoquia(paroquia)
      .then(paroquia => {
        paroquia = paroquia; 

        this.messageService.add({ severity: 'success', detail: 'Informações alteradas com sucesso!' });
      })
      .catch(erro => this.errorHandler.handle(erro));

  } 

  carregarParoquia(codigo: number): void {
    this.adminService.buscarParoquiaPorCodigo()
      .then(paroquia => {
        this.paroquia = paroquia;
      })
      .catch(erro => this.errorHandler.handle(erro));
  }

}
