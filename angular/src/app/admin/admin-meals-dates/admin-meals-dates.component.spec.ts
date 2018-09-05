import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminMealsDatesComponent } from './admin-meals-dates.component';

describe('AdminMealsDatesComponent', () => {
  let component: AdminMealsDatesComponent;
  let fixture: ComponentFixture<AdminMealsDatesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminMealsDatesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminMealsDatesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
