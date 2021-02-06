import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Missa, Paroquia } from '../core/model';


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

  atualizarParoquia(paroquia: Paroquia): Promise<Paroquia> {
    const headers = new HttpHeaders()
      .append('Content-Type', 'application/json');

    return this.http.put<Paroquia>(`${this.paroquiaUrl}/${paroquia.codigo}`, 
    Paroquia.toJsonParoquia(paroquia), { headers })
      .toPromise()
      .then(response => {
        const paroquiaAlterada = response;
        return paroquiaAlterada;
      });
  }

  buscarParoquiaPorCodigo(): Promise<Paroquia> {
    return this.http.get<Paroquia>(`${this.paroquiaUrl}/1`)
      .toPromise()
      .then(response => {
        const paroquia = response;
        return paroquia;
      });
  }

  atualizarMissa(missa: Missa): Promise<Missa> {
    const headers = new HttpHeaders()
      .append('Content-Type', 'application/json');

    return this.http.put<Missa>(`${this.missasUrl}/${missa.id}`, 
    Missa.toJsonMissa(missa), { headers })
      .toPromise()
      .then(response => {
        const missaAlterada = response;
        return missaAlterada;
      });
  }


}
