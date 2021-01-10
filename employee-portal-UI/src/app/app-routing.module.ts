import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import { RegistrationComponent } from 'src/app/registration/registration.component';
import { UserListComponent } from 'src/app/user-list/user-list.component';
import { LandingPageComponent } from 'src/app/landing-page/landing-page.component';


const routes : Routes = [
    {
        path: '',
        component:LandingPageComponent
    },
    {
        path: 'registration',
        component: RegistrationComponent
    },
    {
        path: 'employees',
        component: UserListComponent
    }
]

@NgModule({
   imports : [RouterModule.forRoot(routes)],
   exports: [RouterModule] 
})

export class AppRoutingModule{}