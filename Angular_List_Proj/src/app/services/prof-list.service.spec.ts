import { TestBed } from '@angular/core/testing';

import { ProfListService } from './prof-list.service';

describe('ProfListService', () => {
  let service: ProfListService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ProfListService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
