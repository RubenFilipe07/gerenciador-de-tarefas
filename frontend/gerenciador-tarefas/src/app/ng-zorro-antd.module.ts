import { NgModule } from '@angular/core';

import { BrowserModule } from '@angular/platform-browser';
import { NzLayoutModule } from 'ng-zorro-antd/layout';
import { NzMenuModule } from 'ng-zorro-antd/menu';
import { NzBreadCrumbModule } from 'ng-zorro-antd/breadcrumb'



@NgModule({
    exports: [
        BrowserModule,
        NzLayoutModule,
        NzMenuModule,
        NzBreadCrumbModule,
        
    ]
    })

export class NgZorroAntdModule { }