import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-cursos-form',
  templateUrl: './cursos-form.component.html',
  styleUrls: ['./cursos-form.component.scss']
})
export class CursosFormComponent implements OnInit {

    form: FormGroup;

  constructor(private formBuilder: FormBuilder) {
      this.form = this.formBuilder.group({
      name: [null],
      category: [null]
    });
   }

  ngOnInit(): void {
  }

  onSubmit(){
  }

  onCancel(){
  }
}
