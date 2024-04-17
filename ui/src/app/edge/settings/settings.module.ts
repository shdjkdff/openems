import { NgModule } from '@angular/core';
import { ChangelogModule } from 'src/app/changelog/changelog.module';

import { SharedModule } from './../../shared/shared.module';
import { AlertingComponent } from './alerting/alerting.component';
import { AppModule } from './app/app.module';
import { ChannelsComponent } from './channels/channels.component';
import { IndexComponent as ComponentInstallIndexComponent } from './component/install/index.component';
import { ComponentInstallComponent } from './component/install/install.component';
import { IndexComponent as ComponentUpdateIndexComponent } from './component/update/index.component';
import { ComponentUpdateComponent } from './component/update/update.component';
import { ChartComponent } from './homeassistent/chart/chart';
import { HomeServiceAssistentComponent } from './homeassistent/homeassistent';
import { NetworkOldComponent } from './network.old/network.old.component';
import { NetworkComponent } from './network/network.component';
import { AliasUpdateComponent } from './profile/aliasupdate.component';
import { ProfileComponent } from './profile/profile.component';
import { ServiceAssistantModule } from './serviceassistant/serviceassistant.module';
import { SettingsComponent } from './settings.component';
import { MaintenanceComponent } from './system/maintenance/maintenance';
import { OeSystemUpdateComponent } from './system/oe-system-update.component';
import { SystemComponent } from './system/system.component';
import { SystemExecuteComponent } from './systemexecute/systemexecute.component';
import { SystemUpdateOldComponent } from './systemupdate.old/systemupdate.old.component';
import { JsonrpcTestModule } from './jsonrpctest/jsonrpctest.module';

@NgModule({
  imports: [
    AppModule,
    JsonrpcTestModule,
    SharedModule,
    ServiceAssistantModule,
    ChangelogModule,
  ],
  declarations: [
    AlertingComponent,
    AliasUpdateComponent,
    ChannelsComponent,
    ChartComponent,
    ComponentInstallComponent,
    ComponentInstallIndexComponent,
    ComponentUpdateComponent,
    ComponentUpdateIndexComponent,
    HomeServiceAssistentComponent,
    MaintenanceComponent,
    NetworkComponent,
    NetworkOldComponent,
    OeSystemUpdateComponent,
    ProfileComponent,
    SettingsComponent,
    SystemComponent,
    SystemExecuteComponent,
    SystemUpdateOldComponent,
  ],
  exports: [
    OeSystemUpdateComponent,
  ],
})
export class SettingsModule { }
