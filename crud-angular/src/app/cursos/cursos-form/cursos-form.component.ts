import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Location } from '@angular/common';
import { Curso } from '../model/curso';

import { CursosService } from '../service/cursos.service';

@Component({
  selector: 'app-cursos-form',
  templateUrl: './cursos-form.component.html',
  styleUrls: ['./cursos-form.component.scss']
})
export class CursosFormComponent implements OnInit {

    form: FormGroup;

  constructor(
     private formBuilder : FormBuilder,
     private service : CursosService,
     private snackBar : MatSnackBar,
     private location : Location
     ) {

      this.form = this.formBuilder.group({
        name: [null],
        category: [null]
      });
  }

  ngOnInit(): void {

    }

    onSubmit(){
      this.service.save(this.form.value)
      .subscribe(result => this.onSucess(), error => this.onError());
    }

    onCancel(){
      this.location.back();
    }

    private onSucess(){
      this.snackBar.open('Curso salvo com sucesso!', '', { duration : 5000 });
      this.onCancel();
    }

    private onError(){
      this.snackBar.open('Erro ao salvar curso.', '', { duration : 5000 });

    }
  }
