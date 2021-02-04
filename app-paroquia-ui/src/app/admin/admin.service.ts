import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Missa } from '../core/model';


@Injectable({
  providedIn: 'root'
})
export class AdminService { 

  missasUrl = 'http://localhost:8081/missas';

  paroquiaUrl = 'http://localhost:8081/paroquia';

  constructor(private http: HttpClient) { }

  listarMissa(): Promise<any> {
    return this.http.get(`${this.missasUrl}`)
      .toPromise()
      .then(response => {
        return response;
      });
  }

  listarParoquia(): Promise<any> {
    return this.http.get(`${this.paroquiaUrl}`)
      .toPromise()
      .then(response => {
        return response;
      });
  }

  /*alterarMissa(missa: Missa): Promise<Missa>{

  }*/
}
