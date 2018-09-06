import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PrivacyAdminComponent } from './privacy-admin.component';

describe('PrivacyAdminComponent', () => {
  let component: PrivacyAdminComponent;
  let fixture: ComponentFixture<PrivacyAdminComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PrivacyAdminComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PrivacyAdminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
