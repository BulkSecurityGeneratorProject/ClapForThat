import { IUser } from 'app/core/user/user.model';
import { IEvent } from 'app/shared/model//event.model';

export interface IUserGroup {
    id?: number;
    name?: string;
    active?: boolean;
    users?: IUser[];
    events?: IEvent[];
}

export class UserGroup implements IUserGroup {
    constructor(public id?: number, public name?: string, public active?: boolean, public users?: IUser[], public events?: IEvent[]) {
        this.active = this.active || false;
    }
}
