import { TestBed, inject } from '@angular/core/testing';

import { AdminMealsService } from './admin-meals.service';

describe('AdminMealsService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [AdminMealsService]
    });
  });

  it('should be created', inject([AdminMealsService], (service: AdminMealsService) => {
    expect(service).toBeTruthy();
  }));
});
