import { TestBed } from '@angular/core/testing';

import { ItemlistaService } from './itemlista.service';

describe('ItemlistaService', () => {
  let service: ItemlistaService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ItemlistaService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
