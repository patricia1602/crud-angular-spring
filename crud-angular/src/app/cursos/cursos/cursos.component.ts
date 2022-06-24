import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable, of } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { ErrorDialogComponent } from 'src/app/shared/components/error-dialog/error-dialog.component';
import { Curso } from '../model/curso';
import { CursosService } from '../service/cursos.service';
import { ConfirmDialogComponent } from 'src/app/shared/components/confirm-dialog/confirm-dialog.component';


@Component({
  selector: 'app-cursos',
  templateUrl: './cursos.component.html',
  styleUrls: ['./cursos.component.scss']

})

export class CursosComponent implements OnInit {
  cursos$!: Observable<Curso[]>;
  displayedColumns = ['_id', 'name', 'category', 'actions'];

  constructor(
    private cursosService : CursosService,
    public dialog : MatDialog,
    private router : Router,
    private route : ActivatedRoute,
    private service : CursosService,
    private snackbar : MatSnackBar,
    private location : Location

    ) {

    this.onCursos();

  }

  onCursos() {
    this.cursos$ = this.cursosService.list().pipe(
      catchError((error) => {
        console.log(error)
        this.onError('Erro ao carregar cursos');
        return of([]);

      })
    );
  }

  onError(errorMsg: string) {
    this.dialog.open(ErrorDialogComponent, {
      data: errorMsg,
    });
  }

  //criar um shared
  onCancel() {
    this.location.back();

  }

  private onSuccess(actionMessage: string) {
    this.snackbar.open(actionMessage, '', {
      duration: 5000,

    });

    this.onCursos();

  }

  ngOnInit(): void {}

  onAdd() {
    this.router.navigate(['new'], { relativeTo: this.route });
  }

  onEdit(pCurso: Curso) {
    this.router.navigate(['new', { curso: JSON.stringify(pCurso) }], {
      relativeTo: this.route,

    });
  }

  onClickDelete(_id: string) {
      async () => this.onDelete(_id);

    }

  onDelete(id: string) {
    this.service.delete(id).subscribe(
      (result) => this.onSuccess('delete success'),
      (error) => this.onError('delete error')

      );
  }

    openDialog(pTitle: String, pDescription: string, pOnConfirm: () => {}){
        const dialogRef = this.dialog.open(ConfirmDialogComponent, {
          data : {
            title : pTitle,
            description : pDescription,
            onConfirm : pOnConfirm

          },
        });
    }

    //dialogRef.afterClosed().subscribe((result) => {
      //console.log('The dialog was closed');
    //});
  }
