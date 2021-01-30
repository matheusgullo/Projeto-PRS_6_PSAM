import { Component, OnInit } from '@angular/core';
import { PaginaService } from './pagina.service';

@Component({
  selector: 'app-pagina',
  templateUrl: './pagina.component.html',
  styleUrls: ['./pagina.component.css']
})
export class PaginaComponent implements OnInit {

  listaMissa = [];

  infoParoquia = [];

  constructor(private paginaService: PaginaService) { }

  ngOnInit(): void {
    this.listarMissa();
    this.listarParoquia();
  }

  listarMissa(): void{
    this.paginaService.listarMissa()
    .then(resultado => {
      this.listaMissa = resultado;
    });
  }

  listarParoquia(): void{
    this.paginaService.listarParoquia()
    .then(resultado => {
      this.infoParoquia = resultado;
    });
  }
}
