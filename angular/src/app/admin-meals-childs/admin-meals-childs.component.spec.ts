import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminMealsChildsComponent } from './admin-meals-childs.component';

describe('AdminMealsChildsComponent', () => {
  let component: AdminMealsChildsComponent;
  let fixture: ComponentFixture<AdminMealsChildsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminMealsChildsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminMealsChildsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
