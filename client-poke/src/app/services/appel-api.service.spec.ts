import { TestBed } from '@angular/core/testing';

import { AppelAPIService } from './appel-api.service';

describe('AppelAPIService', () => {
  let service: AppelAPIService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AppelAPIService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
