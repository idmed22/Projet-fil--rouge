import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AnalyseListComponent } from './analyse-list.component';

describe('AnalyseListComponent', () => {
  let component: AnalyseListComponent;
  let fixture: ComponentFixture<AnalyseListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AnalyseListComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AnalyseListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
