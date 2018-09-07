import { TestBed, inject } from '@angular/core/testing';

import { PrivacyAdminService } from './privacy-admin.service';

describe('PrivacyAdminService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [PrivacyAdminService]
    });
  });

  it('should be created', inject([PrivacyAdminService], (service: PrivacyAdminService) => {
    expect(service).toBeTruthy();
  }));
});
