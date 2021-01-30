import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';


@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css']
})
export class LoginFormComponent implements OnInit {

  msg: any;

  constructor(private auth: AuthService) { }

  ngOnInit(): void {
  }

  login(usuario: string, senha: string): void {
    this.auth.login(usuario, senha)
      .then(() => {
        this.msg = 'redirecionar para /atualizacoes';
      })
      .catch(() => {
        this.msg = 'Usuário ou senha inválida!';
      });
  }

}
