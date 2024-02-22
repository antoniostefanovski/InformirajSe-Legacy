import { User } from "./User";

export class Blog {
    public id: string | undefined;

    public title: string | undefined;

    public contentBody: string | undefined;

    public dateCreated: string = "";

    public user?: User;
};