import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HistoryPedidoComponent } from './history-pedido.component';

describe('HistoryPedidoComponent', () => {
  let component: HistoryPedidoComponent;
  let fixture: ComponentFixture<HistoryPedidoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HistoryPedidoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(HistoryPedidoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
