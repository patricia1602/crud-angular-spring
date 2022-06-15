import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { MatSnackBar, _SnackBarContainer } from '@angular/material/snack-bar';
import { ActivatedRoute } from '@angular/router';
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
     private snackBar : MatSnackBar
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
      .subscribe(result => console.log(result), error => this.onError());
    }

    onCancel(){

    }

    private onError(){
      this.snackBar.open('Erro ao salvar curso.', '', { duration : 5000 });

    }
  }
