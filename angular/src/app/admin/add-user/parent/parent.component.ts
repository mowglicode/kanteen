import {Component, OnInit} from '@angular/core';
import {AdminUserService} from "../admin-user.service";

@Component({
  selector: 'app-parent',
  templateUrl: './parent.component.html',
  styleUrls: ['./parent.component.css']
})
export class ParentComponent implements OnInit {
  name: string;
  mail: string;
  tel: string;
  pass: string = generate(6);

  constructor(public service: AdminUserService) {
    service.getAllParents();
  }

  ngOnInit() {
  }

  createUser() {

  }

  onSubmit() {
    this.service.postNewParent(this.name, this.mail, this.tel, this.pass);
    this.name = undefined;
    this.mail = undefined;
    this.tel = undefined;
  }

}

function generate(taille: number): string {
  let chars: string = "azertyuiopqsdfghjklmwxcvbn123456789";
  let pass: string = "";
  for (let i = 0; i < taille; i++) {
    let x: number = Math.floor((Math.random() * chars.length - 1));
    pass += chars.charAt(x);
  }
  return pass;
}
