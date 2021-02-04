export class Endereco{
    logradouro: string;
    numero: string;
    bairro: string;
    cidade: string;
    cep: string;
}

export class Missa {
    id: number;
    diaSemana: [];
    horarios: [];

    static toJsonMissa(missa: Missa): any {
        return {
          id: missa.id,
          diaSemana: missa.diaSemana,
          horarios: missa.horarios
        };
    }
}
  
export class Paroquia {
    codigo: number;
    sobre: string;
    telefone: string;
    email: string;
    endereco = new Endereco();

    static toJsonParoquia(paroquia: Paroquia): any {
        return {
            codigo: paroquia.codigo,
            sobre: paroquia.sobre,
            telefone: paroquia.telefone,
            email: paroquia.email,
            endereco: paroquia.endereco
        };
    }
}

 