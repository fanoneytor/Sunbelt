import { TestBed } from '@angular/core/testing';

import { ApiConsultaService } from './api-consulta.service';

describe('ApiConsultaService', () => {
  let service: ApiConsultaService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ApiConsultaService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
