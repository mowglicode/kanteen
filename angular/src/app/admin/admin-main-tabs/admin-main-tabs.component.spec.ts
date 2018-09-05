import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminMainTabsComponent } from './admin-main-tabs.component';

describe('AdminMainTabsComponent', () => {
  let component: AdminMainTabsComponent;
  let fixture: ComponentFixture<AdminMainTabsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminMainTabsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminMainTabsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
