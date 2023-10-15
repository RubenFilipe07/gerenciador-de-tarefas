import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { NzLayoutModule } from 'ng-zorro-antd/layout';
import { NzMenuModule } from 'ng-zorro-antd/menu';
import { NzBreadCrumbModule } from 'ng-zorro-antd/breadcrumb';
import { NzTableModule } from 'ng-zorro-antd/table';
import { NzDividerModule } from 'ng-zorro-antd/divider';
import { NzButtonModule } from 'ng-zorro-antd/button';
import { NzAlertModule } from 'ng-zorro-antd/alert';
import { NzFormModule } from 'ng-zorro-antd/form';
import { NzInputModule } from 'ng-zorro-antd/input';
import { NzSelectModule } from 'ng-zorro-antd/select';
import { NzModalModule } from 'ng-zorro-antd/modal';
import { NzDatePickerModule } from 'ng-zorro-antd/date-picker';


@NgModule({
  exports: [
    BrowserModule,
    NzLayoutModule,
    NzMenuModule,
    NzBreadCrumbModule,
    NzTableModule,
    NzDividerModule,
    NzButtonModule,
    NzAlertModule,
    NzFormModule,
    NzInputModule,
    NzSelectModule,
    NzModalModule,
    NzDatePickerModule,
  ]
})
export class NgZorroAntdModule { }
